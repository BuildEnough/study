import React from 'react'
import { FacebookIcon, FacebookShareButton, TwitterShareButton, XIcon } from "react-share";
import { base_url } from "../../App";

const ShareButtonGroup = ({testParam, resultParam, renderTestInfo}) => {
  return (
    <div>
      <h3>친구에게 공유하기</h3>
      <div>
        <FacebookShareButton
          url={`${base_url}/${testParam}/result/${resultParam}`}
          hashtag={`#${renderTestInfo?.info?.mainTitle}`}
        >
          <FacebookIcon round={true} size={48}/>
        </FacebookShareButton>
        <TwitterShareButton
          title={renderTestInfo?.info?.mainTitle}
          url={`${base_url}/${testParam}/result/${resultParam}`}
          hashtags={[renderTestInfo?.info?.mainTitle]}
        >
          <XIcon round={true} size={48}/>
        </TwitterShareButton>
      </div>
    </div>
  );
};

export default ShareButtonGroup