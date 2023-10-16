package com.insta.instagram.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insta.instagram.dto.UserDTO;
import com.insta.instagram.exceptions.CommentException;
import com.insta.instagram.exceptions.PostException;
import com.insta.instagram.exceptions.UserException;
import com.insta.instagram.model.Comment;
import com.insta.instagram.model.Post;
import com.insta.instagram.model.User;
import com.insta.instagram.repository.CommentRepository;
import com.insta.instagram.repository.PostRepository;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Override
    public Comment createComment(Comment comment, Integer postId, Integer userId) throws UserException, PostException {
        
        User user = userService.findUserById(userId);

        Post post = postService.findPostById(postId);

        UserDTO userDTO = new UserDTO();

        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUserImage(user.getImage());
        userDTO.setUsername(user.getUsername());
        
        comment.setUser(userDTO);
        comment.setCreatedAt(LocalDateTime.now());

        Comment createdComment = commentRepository.save(comment);

        post.getComments().add(createdComment);

        postRepository.save(post);

        return createdComment;

    }

    @Override
    public Comment findCommentById(Integer commentId) throws CommentException {
        
        Optional<Comment> opt = commentRepository.findById(commentId);

        if(opt.isPresent())
        {
            return opt.get();
        }

        throw new CommentException("Comment not exist with id: "+commentId);
        
    }

    @Override
    public Comment likeComment(Integer commentId, Integer userId) throws CommentException, UserException {
       
        User user = userService.findUserById(userId);
        Comment comment = findCommentById(commentId);
 
        UserDTO userDTO = new UserDTO();

        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUserImage(user.getImage());
        userDTO.setUsername(user.getUsername());

        comment.getLikedByUsers().add(userDTO);

        return commentRepository.save(comment);
        
    }

    @Override
    public Comment unlikeComment(Integer commentId, Integer userId) throws CommentException, UserException {

        User user = userService.findUserById(userId);
        Comment comment = findCommentById(commentId);

        UserDTO userDTO = new UserDTO();

        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUserImage(user.getImage());
        userDTO.setUsername(user.getUsername());

        comment.getLikedByUsers().remove(userDTO);

        return commentRepository.save(comment);

    }
    
}
