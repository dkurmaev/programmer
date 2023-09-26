import React from 'react';

const NavItem: FC<{itemTitle: string}> = ({itemTitle}) => {
  if (itemTitle === 'Home') {
    return (
      <div>NavItem</div>
    );
  }
};

export default NavItem;