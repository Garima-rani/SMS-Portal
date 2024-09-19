import React, { useState } from "react";
// import players from "./players";
import "./Table.css";

const MyTable = ({ data }) => {
  const [expandedRow, setExpandedRow] = useState(null); // Store only one row's ID
  const [message, setMessage] = useState(null);
  const handleExpand = async (id) => {
    // If the currently expanded row is clicked, collapse it, otherwise expand the new one

    if (expandedRow === id) {
      // console.log("Collapsing " + player.firstName);
      setExpandedRow(null); // Collapse the row
    } else {
      console.log("Expanding ");
      try {
        console.log(id);
        const response = await fetch(
          `http://localhost:8080/sms/generate/${id}`
        );
        console.log(response);
        const data = await response.text();
        console.log(data);
        setMessage(data);
      } catch (err) {
        console.log(err);
      }
      setExpandedRow(id); // Expand the new row
    }

    console.log("Currently expanded row: " + expandedRow);
  };
  const isExpanded = (id) => {
    return expandedRow === id;
  };

  //   const expandAll = (players) => {
  //     if (expandedRows.length === players.length) {
  //       setExpandedRows([]);
  //       console.log("Collapsing all...");
  //     } else {
  //       let newExpandedRows = players.map((player) => player.id);
  //       setExpandedRows([...newExpandedRows]);
  //       console.log("Expanding all...");
  //       console.log("Expanded rows " + newExpandedRows.length);
  //     }
  //   };

  const getRows = (id) => {
    let rows = [];

    const firstRow = (
      <tr
        key={id}
        className={`${isExpanded(id) ? "bg-gray-200" : ""} text-center`}
      >
        <td>{id}</td>
        <td className="">{"-"}</td>
        <td className="">{"-"}</td>
        <td className="">{"-"}</td>
        <td className="">{"-"}</td>
        <td className="">{"-"}</td>
        <td>
          {
            <button onClick={() => handleExpand(id)}>
              {isExpanded(id) ? "-" : "+"}
            </button>
          }
        </td>
      </tr>
    );

    rows.push(firstRow);

    if (isExpanded(id)) {
      const messageRow = (
        <tr className="bg-gray-200 ">
          <td colSpan="7" className="player-details  text-center">
            <br />
            <dl className="attribute text-center">
              <dt className="attribute-name">Message: </dt>
              <dd className="attribute-value">{message}</dd>
            </dl>
            <br />
          </td>
        </tr>
      );

      rows.push(messageRow);
    }

    return rows;
  };

  const getPlayerTable = (data) => {
    const playerRows = data.map((id, index) => getRows(id));

    return (
      <table className="my-table w-[90%] mx-auto my-10 mb-20 py-20 border border-1 border-black border-collapse ">
        <thead>
          <tr className="bg-gray-200">
            <th>Id</th>
            <th>Latency</th>
            <th>User name</th>
            <th>Mobile No.</th>
            <th>SMS Acc Id</th>
            <th>Source IP</th>

            {/* <th onClick={() => expandAll(players)}> */}
            <th>+</th>
          </tr>
        </thead>
        <tbody>{playerRows}</tbody>
      </table>
    );
  };

  return <div>{getPlayerTable(data)}</div>;
};

export default MyTable;
