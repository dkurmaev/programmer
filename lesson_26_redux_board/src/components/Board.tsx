import React from "react";
import { useSelector, useDispatch } from "react-redux";
import Square from "./Square";
import { makeMove, restart, selectSquares, selectXIsNext } from "../store/boardSlice";
import { calculateWinner } from "../store/boardSlice";
import { RootState } from "../app/store";
import './Board.css'; // Импорт файла стилей


const Board = () => {
    const squares: (string | null)[] = useSelector((state: RootState) => selectSquares(state));
    const xIsNext = useSelector((state: RootState) => selectXIsNext(state));
    const dispatch = useDispatch();
    const winner = calculateWinner(squares);
    let status;
    if (winner) {
        status = `Победитель: ${winner}`;
    } else {
        status = `Следующий игрок: ${squares.every((square) => square) ? 'Ничья' : xIsNext ? 'X' : 'O'}`;
    }

    const handleSquareClick = (index: number) => {
        if (!winner && !squares[index]) {
            dispatch(makeMove(index));
        }
    };

    const handleRestart = () => {
        dispatch(restart());
    };

    return (
        <div className="board">
            <div className="board-row">
                <Square value={squares[0]} onClick={() => handleSquareClick(0)} />
                <Square value={squares[1]} onClick={() => handleSquareClick(1)} />
                <Square value={squares[2]} onClick={() => handleSquareClick(2)} />
            </div>
            <div className="board-row">
                <Square value={squares[3]} onClick={() => handleSquareClick(3)} />
                <Square value={squares[4]} onClick={() => handleSquareClick(4)} />
                <Square value={squares[5]} onClick={() => handleSquareClick(5)} />
            </div>
            <div className="board-row">
                <Square value={squares[6]} onClick={() => handleSquareClick(6)} />
                <Square value={squares[7]} onClick={() => handleSquareClick(7)} />
                <Square value={squares[8]} onClick={() => handleSquareClick(8)} />
            </div>
            <div className="status">{status}</div>
            <button className="restart-button" onClick={handleRestart}>
                Начать заново
            </button>
        </div>
    );
};

export default Board;
