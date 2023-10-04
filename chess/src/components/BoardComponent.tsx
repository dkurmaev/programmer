import React, { FC } from 'react';
import { Board } from '../models/Board';
import CellComponent from './CellComponent';
import { Cell } from '../models/Cell';

interface BoardProps {
    board: Board;
    setBoard: (board: Board) => void;
}

const BoardComponent: FC<BoardProps> = ({ board, setBoard }) => {
    const [selectedCell, setSelectedCell] = React.useState<Cell | null>(null);

    function click(cell: Cell) {
        if(selectedCell && selectedCell !== cell && selectedCell.figure?.canMove(cell)) {
            selectedCell.moveFigure(cell);
            setSelectedCell(null);
                
        }else{
            setSelectedCell(cell);
        
        }
        
    }

    React.useEffect(() => {
        highlightCells();
    });

    function highlightCells() {
        board.highlightCells(selectedCell);
        setBoard(board.getCopyBoard());
    }

    return (
        <div className='board'>
            {board.cells.map((row: Cell[], index: number) => (
                <React.Fragment key={index}>
                    {row.map(cell => (
                        <CellComponent
                            click={click}
                            key={cell.id}
                            cell={cell}
                            selected={cell.x === selectedCell?.x && cell.y === selectedCell?.y}
                        />
                    ))}
                </React.Fragment>
            ))}
        </div>
    );
};

export default BoardComponent;