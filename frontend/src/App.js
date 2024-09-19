import { useEffect, useState } from "react";
import Header from "./components/common/Header";
import MyTable from "./components/common/Table/Table";

function App() {
  const [ids , setIds] = useState([]) 
  useEffect(()=>{
    fetchIds()
  } , [])
  const fetchIds = async()=>{
    try{
      const response = await fetch('http://localhost:8080/api/communication-logs/ids');
      const data = await response.json() ;
      console.log(data) ; 
      setIds(data) ; 
    }catch(err){
      console.log(err)
    }
  }
  return (
    <div className="App">
      <Header />
      <MyTable data={ids} />
    </div>
  );
}

export default App;
