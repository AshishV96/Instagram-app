package com.insta.instagram.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insta.instagram.dto.UserDTO;
import com.insta.instagram.exceptions.PostException;
import com.insta.instagram.exceptions.UserException;
import com.insta.instagram.model.Post;
import com.insta.instagram.model.User;
import com.insta.instagram.repository.PostRepository;
import com.insta.instagram.repository.UserRepository;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public Post createPost(Post post, Integer userId) throws UserException {
        
        User user = userService.findUserById(userId);

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUserImage(user.getImage());
        userDTO.setUsername(user.getUsername());

        post.setUser(userDTO);

        Post createdPost = postRepository.save(post);
        
        return createdPost;
    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws UserException, PostException {
        
        Post post = findPostById(postId);

        User user = userService.findUserById(userId);

        if(post.getUser().getId().equals(user.getId()))
        {
            postRepository.deleteById(post.getId());
            return "Post deleted successfully";
        }

        throw new PostException("You can't delete other user's post");
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) throws UserException {

        List<Post> posts = postRepository.findByUserId(userId);

        if(posts.size()==0)
        {
            throw new UserException("this user does not have any post");
        }

        return posts;
    }

    @Override
    public Post findPostById(Integer postId) throws PostException {
        
        Optional<Post> opt = postRepository.findById(postId);

        if(opt.isPresent())
        {
            return opt.get();
        }

        throw new PostException("Post not found with id "+postId);
    }

    @Override
    public List<Post> findAllPostByUserIds(List<Integer> userIds) throws PostException, UserException {

        List<Post> posts = postRepository.findAllById(userIds);

        if(posts.size() == 0)
        {
            throw new PostException("No post available"); 
        }

        return posts;
    }

    @Override
    public String savedPost(Integer postId, Integer userId) throws PostException, UserException {
        
        Post post = findPostById(postId);

        User user = userService.findUserById(userId);

        if(!user.getSavedPost().contains(post))
        {
            user.getSavedPost().add(post);
            userRepository.save(user);
        }

        return "Post saved successfully";
    }

    @Override
    public String unsavedPost(Integer postId, Integer userId) throws PostException, UserException {
       
        Post post = findPostById(postId);

        User user = userService.findUserById(userId);

        if(user.getSavedPost().contains(post))
        {
            user.getSavedPost().remove(post);
            userRepository.save(user);
        }

        return "Post removed successfully";
    }

    @Override
    public Post likePost(Integer postId, Integer userId) throws UserException, PostException {
        
        Post post = findPostById(postId);

        User user = userService.findUserById(userId);
        
        UserDTO userDTO = new UserDTO();

        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUserImage(user.getImage());
        userDTO.setUsername(user.getUsername());

        post.getLikedByUsers().add(userDTO);

        return postRepository.save(post);
    }

    @Override
    public Post unlikePost(Integer postId, Integer userId) throws UserException, PostException {
        
        Post post = findPostById(postId);

        User user = userService.findUserById(userId);
        
        UserDTO userDTO = new UserDTO();

        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUserImage(user.getImage());
        userDTO.setUsername(user.getUsername());

        post.getLikedByUsers().remove(userDTO);

        return postRepository.save(post);
    }
    
}
