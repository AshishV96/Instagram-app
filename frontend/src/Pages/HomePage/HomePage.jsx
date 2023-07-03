import React from 'react'
import StoryCircle from '../../Components/Story/StoryCircle'
import HomeRight from '../../Components/HomeRight/HomeRight'
import PostCard from '../../Components/Post/PostCard'

const HomePage = () => {

  return (
    <div>
      <div className='mt-10 flex w-full justify-center'>
        <div className='w-[44%] px-10'>
          <div className='storyDiv flex space-x-2 border p-4 rounded-md justify-start w-full'>
            {[1, 1, 1].map((items) => <StoryCircle />)}
          </div>
          <div className='justify-between space-y-10 w-full mt-10'>
            {[1, 1].map((items) => <PostCard />)}
          </div>
        </div>
        <div className='w-[27%]'>
          <HomeRight />
        </div>
      </div>

    </div>
  )
}

export default HomePage
