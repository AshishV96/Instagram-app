import React, { useState } from 'react'
import { AiFillHeart, AiOutlineHeart } from 'react-icons/ai'

const CommentCard = () => {

    const [isCommentLike, setIsCommentLike] = useState(false)

    const handleLikeComment = () => {
        setIsCommentLike(!isCommentLike)
    }

    return (
        <div>
            <div className='flex items-center py-5'>
                <div className='flex items-center'>
                    <div>
                        <img className='w-9 h-9 rounded-full' src="https://cdn.pixabay.com/photo/2023/05/29/14/05/mountains-8026175__340.jpg" alt="" />
                    </div>
                    <div className='ml-3'>
                        <p>
                            <span className='font-semibold'>username</span>
                            <span className='ml-2'>nice post</span>
                        </p>
                        <div className='flex items-center space-x-3 text-xs opacity-60 pt-2'>
                            <span>1 min ago</span>
                            <span>23 likes</span>
                        </div>
                    </div>
                </div>
                <div className='ml-52'>
                {isCommentLike ? <AiFillHeart onClick={handleLikeComment} className='text-xs hover:opacity-50 cursor-pointer text-red-600' /> : <AiOutlineHeart onClick={handleLikeComment} className='text-xs hover:opacity-50 cursor-pointer' />}
                </div>
            </div>
        </div>
    )
}

export default CommentCard
