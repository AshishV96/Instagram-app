import React from 'react'
import StoryViewer from '../../Components/StoryComponents/StoryViewer'

const Story = () => {

    const story = [
        {
            image:"https://images.pexels.com/photos/17111340/pexels-photo-17111340/free-photo-of-city-water-street-building.jpeg?auto=compress&cs=tinysrgb&w=400&lazy=load"
        },
        {
            image:"https://images.pexels.com/photos/9390250/pexels-photo-9390250.jpeg?auto=compress&cs=tinysrgb&w=400&lazy=load"
        },
        {
            image:"https://images.pexels.com/photos/16981071/pexels-photo-16981071/free-photo-of-city-man-people-woman.jpeg?auto=compress&cs=tinysrgb&w=400&lazy=load"
        },
        {
            image:"https://images.pexels.com/photos/11843595/pexels-photo-11843595.jpeg?auto=compress&cs=tinysrgb&w=400&lazy=load"
        },
        {
            image:"https://images.pexels.com/photos/16447305/pexels-photo-16447305/free-photo-of-city-art-street-building.jpeg?auto=compress&cs=tinysrgb&w=400&lazy=load"
        }
    ]

  return (
    <div>
      <StoryViewer stories={story}/>
    </div>
  )
}

export default Story
