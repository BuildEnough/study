import { useEffect } from "react";
import { useParams } from "react-router-dom";

function Test() {
    const { testParam } = useParams();
    
    useEffect(() => {
        console.log(testParam);
    }, [testParam]);

    return <div>{testParam} 인트로 페이지</div>
}

export default Test;