import React, { useEffect, useRef } from "react";

export default function GetInputModal({
  name,
  func,
  hidden,
  setModalVisibility,
  width = "w-full",
}) {
  useEffect(() => {
    if(inpRef.current)
      inpRef.current.focus();
  })
  let inpRef = useRef(null);

  return (
    !hidden && (
      <div className="rounded-xl absolute w-full top-0 left-0 h-full z-10">
        <div className="flex flex-col bg-modal-bg dark:bg-modal-bg-dark gap-6 justify-center items-center rounded-xl h-full p-8 relative">
          <input
            ref={inpRef}
            type="text"
            placeholder="Enter your Task"
            className={`${width} large-mobile:w-full px-1 bg-input-bg dark:bg-input-bg-dark text-input-text dark:text-input-text-dark border outline-0`}
            name="input"
          />
          <div className="flex gap-4 justify-center w-full">
            <button
              className=" bg-modal-button-bg text-modal-button-text px-4"
              onClick={() => func(inpRef.current.value)}
            >
              {name}
            </button>
          </div>

          <img
            src="xmark-solid.svg"
            alt=""
            className="absolute top-1 right-1 hover:cursor-pointer"
            onClick={() => setModalVisibility(1)}
          />
        </div>
      </div>
    )
  );
}
