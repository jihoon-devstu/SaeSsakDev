import './App.css'

//---- default export
// 중괄호 없이 import
// import 시 이름을 바꿀수 있음.
import Post from './component/Post.tsx'
import Member from './component/User.tsx'

// named export 처리하기
/**
 * 중괄호 안에 import
 * 내보낸 이름과 동일한 이름으로 import
 * 이름을 바꾸고 싶으면 as 키워드 활용
 * 
 */
import {PI} from "./api/carculate";
import {getArea} from "./api/carculate";
import {feature as f} from "./api/carculate";



function App() {
  

  return (
    <>
      <Post/>
      <Member/>
      <div>{PI}</div>
      <div>{getArea(10)}</div>
      <div>{f.add(1,2)}</div>
    </>
  )
}

export default App
