import React from "react";

function Header() {
  return (
    <div className="w-full h-[65px] bg-[whitesmoke] shadow-md flex  items-center bg-blue-400 px-5 pl-2">
      <div className=" flex !justify-self-start items-center gap-2">
      <img src="./nfsa-logo.png" className="w-[50px] h-[50px]" />
      <div className="flex flex-col text-sm text-nowrap">
        <h1 className="font-bold">Government of India</h1>
        <p>Department of Food & Public distribution <br />Ministry of Consumer Affairs, Food & Public Distribution</p>
      </div>
      
        </div>
        <h2 className="w-full text-center items-center content-center self-center justify-self-center font-bold ">SMS Dashboard</h2>
    </div>
  );
}

export default Header;
