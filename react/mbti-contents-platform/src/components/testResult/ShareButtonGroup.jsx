import React from 'react'
import { FacebookIcon, FacebookShareButton, TwitterShareButton, XIcon } from "react-share";
import { base_url } from "../../App";
import styles from './shareButtonGroup.module.css';

const ShareButtonGroup = ({testParam, resultParam, renderTestInfo}) => {
  const shareUrl = `${base_url}/${testParam}/result/${resultParam}`;

  const handleCopy = async () => {
    try {
      await navigator.clipboard.writeText(shareUrl);
      alert("URL이 복사되었습니다!");
    } catch (err) {
      alert("복사 실패. 브라우저 설정을 확인해주세요.");
    }
  };

  return (
    <div>
      <h3>친구에게 공유하기</h3>
      <div className={styles.shraeButtonDiv}>
        <FacebookShareButton
          url={`${base_url}/${testParam}/result/${resultParam}`}
          hashtag={`#${renderTestInfo?.info?.mainTitle}`}
        >
          <FacebookIcon round={true} size={48} className={styles.socialMediaIcon}/>
        </FacebookShareButton>
        <TwitterShareButton
          title={renderTestInfo?.info?.mainTitle}
          url={`${base_url}/${testParam}/result/${resultParam}`}
          hashtags={[renderTestInfo?.info?.mainTitle]}
        >
          <XIcon round={true} size={48} className={styles.socialMediaIcon}/>
          </TwitterShareButton>
            <button
            onClick={handleCopy}
            className={styles.urlShareButton}>URL</button>
      </div>
    </div>
  );
};

export default ShareButtonGroup