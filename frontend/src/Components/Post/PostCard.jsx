import React, { useState } from 'react'
import { BsBookmark, BsBookmarkFill, BsEmojiSmile, BsThreeDots } from 'react-icons/bs'
import { AiFillHeart, AiOutlineHeart } from 'react-icons/ai'
import { FaRegComment } from 'react-icons/fa'
import { RiSendPlaneLine } from 'react-icons/ri'
import "./PostCard.css"
import CommentModel from '../Comment/CommentModel'
import { useDisclosure } from '@chakra-ui/react'

const PostCard = () => {

  const [showDropDown, setShowDropDown] = useState(false)
  const [isPostLiked, setIsPostliked] = useState(false)
  const [isSaved, setIsSaved] = useState(false)
  const { isOpen, onOpen, onClose } = useDisclosure()

  const handleSavePost = () => {
    setIsSaved(!isSaved)
  }

  const handlePostLike = () => {
    setIsPostliked(!isPostLiked)
  }

  const handleClick = () => {
    setShowDropDown(!showDropDown);
  }

  const handleOpenCommentModel=()=>{
    onOpen()
  } 

  return (
    <div>
      <div className='border rounded-md w-full'>
        <div className='flex justify-between items-center w-full py-4 px-5'>
          <div className='flex item-center'>
            <img className='h-12 w-12 rounded-full' src="https://cdn.pixabay.com/photo/2023/04/26/15/51/lighthouse-7952696_1280.jpg" alt="" />
            <div className='pl-2'>
              <p className='font-seminold text-sm'>username</p>
              <p className='font-thin text-sm'>location</p>
            </div>
          </div>

          <div className='dropdown'>
            <BsThreeDots className='dots' onClick={handleClick} />
            <div className='dropdown-content'>
              {showDropDown && <p className='bg-black text-white py-1 px-4 rounded-md cursor-pointer'>Delete</p>}
            </div>
          </div>

        </div>

        <div className='w-full'>
          <img className='w-full' src="https://cdn.pixabay.com/photo/2023/05/18/19/56/crocodile-8003179__340.jpg" alt="" />
        </div>

        <div className='flex justify-between items-center w-full px-5 py-5'>
          <div className='flex items-center space-x-2'>
            {isPostLiked ? <AiFillHeart className='text-2xl hover:opacity-50 cursor-pointer text-red-600' onClick={handlePostLike} /> : <AiOutlineHeart className='text-2xl hover:opacity-50 cursor-pointer' onClick={handlePostLike} />}
            <FaRegComment onClick={handleOpenCommentModel} className='text-xl hover:opacity-50 cursor-pointer' />
            <RiSendPlaneLine className='text-xl hover:opacity-50 cursor-pointer' />
          </div>
          <div className='cursor-pointer'>
            {isSaved ? <BsBookmarkFill onClick={handleSavePost} className='text-xl hover:opacity-50 cursor-pointer' /> : <BsBookmark onClick={handleSavePost} className='text-xl hover:opacity-50 cursor-pointer' />}
          </div>
        </div>

        <div className='w-full py-2 px-5'>
          <p>10 likes</p>
          <p className='opacity-50 py-2 cursor-pointer'>view all comments</p>
        </div>

        <div className='border border-t w-full'>
          <div className='flex w-full items-center px-5'>
            <BsEmojiSmile/>
            <input className='commentInput' type="text" placeholder='Add a comment...' />
          </div>
        </div>
      </div>
      <CommentModel handlePostLike={handlePostLike} onClose={onClose} isOpen={isOpen} handleSavePost={handleSavePost} isPostLiked={isPostLiked} isSaved={isSaved} />
    </div>
  )
}

export default PostCard
