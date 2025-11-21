import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import IntroRenderer from "../components/test/IntroRenderer";
import { TESTS } from "../data/TESTS";

function Test() {
    const { testParam } = useParams();
    const nevigate = useNavigate();
    const [currentTest, setCurrentTest] = useState({});
    
    useEffect(() => {
        console.log(testParam);
        const theTest = TESTS?.find((test) => (test?.info?.mainUrl === testParam));
        if(!theTest) {
            alert('해당 테스트는 존재하지 않습니다');
            return nevigate("/");
        }
        console.log(theTest);
        setCurrentTest(theTest);
    }, [testParam]);

    return (
        <div>
            <IntroRenderer currentTest={currentTest} />
        </div>
    );
}

export default Test;