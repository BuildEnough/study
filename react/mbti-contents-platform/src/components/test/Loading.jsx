import Lottie from "lottie-react";
import animationData from "../../assets/loading-animation.json";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function Loading({mbtiScore, currentTest}) {
    const navigate = useNavigate();
    const [finalQuery, setFinalQuery] = useState("");
    const defaultOptions = {
        loop: true,
        autoplay: true,
        animationData: animationData.default,
        rendererSettings: {
            preserveAspectRatio: "xMidYMid slice",
        },
    };

    const loadingTime = 3700; //

    useEffect(() => {
        const mbtiPairs = [
            ["E", "I"],
            ["S", "N"],
            ["T", "F"],
            ["J", "P"]
        ];

        let resultType = "";
        for (let pair of mbtiPairs) {
            let firstTpye = pair[0];
            let secondType = pair[1];
            let firstTypeScore = mbtiScore[firstTpye];
            let secondTypeScore = mbtiScore[secondType];
            firstTypeScore > secondTypeScore
            ? (resultType += firstTpye)
            : (resultType += secondType);
        }

        const resultQuery = currentTest?.results?.find(
            (result) => result?.type === resultType
        )?.query;
        setFinalQuery(resultQuery);
    }, [mbtiScore, currentTest]);

    useEffect(() => {
        let timeout = setTimeout(() => {
            finalQuery &&
                navigate(`/${currentTest?.info?.mainUrl}/result/${finalQuery}`);
        }, loadingTime);
    return () => {
        clearTimeout(timeout);
    }
    }, [loadingTime, navigate, finalQuery, currentTest?.info?.mainUrl]);

    return <div>Loading</div>
    // return (
    //     <Lottie
    //         options={defaultOptions}
    //         height={250}
    //         width={250}
    //         style={{ marginTop: "10re,"}} 
    //     />
    // );
    
}

export default Loading;
