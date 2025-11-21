import { useState } from "react";
import Intro from "./Intro";
import Quiz from "./Quiz";
import Loading from "./Loading";

function IntroRenderer({ currentTest }) {
        const [mode, setMode] = useState("intro");
        if(mode === 'intro') {
            return <Intro info={currentTest?.info} setMode={setMode} />;
        } else if (mode === 'quiz') {
            return <Quiz />;
        } else if (mode === 'loading') {
            return <Loading />;
        } else {
            return <div>잘못된 페이지입니다.</div>
        }

    return <div>{currentTest?.info?.mainTitle}</div>;
}

export default IntroRenderer;