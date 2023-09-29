import React, { FC, useContext } from "react";
import { PageContext } from "../App";

const NavItem: FC<{
    itemTitle: string;
    changePage: (currentPage: string) => void;
}> = ({ itemTitle, changePage }) => {
  
  useContext(PageContext);
  
  return (
    <li className="commonButton" onClick={() => changePage(itemTitle)}>
            {itemTitle}
        </li>
    );
};

export default NavItem;