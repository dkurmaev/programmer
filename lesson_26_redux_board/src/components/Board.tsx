import React from "react";
import { useSelector, useDispatch } from "react-redux";
import Square from "./Square";
import { makeMove, restart, selectSquares, selectXIsNext } from "../store/boardSlice";
import { calculateWinner } from "../store/boardSlice";
import { RootState } from "../app/store";
import './Board.css';
import 'bootstrap/dist/css/bootstrap.min.css';


const Board = () => {
    const squares: (string | null)[] = useSelector((state: RootState) => selectSquares(state));
    const xIsNext = useSelector((state: RootState) => selectXIsNext(state));
    const dispatch = useDispatch();
    const winner = calculateWinner(squares);

    let status;
    if (winner) {
        status = `Winner: ${winner}`;
    } else {
        status = `Next player: ${squares.every((square) => square) ? 'It`s a Draw' : xIsNext ? 'X' : 'O'}`; 
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
        <div className="container mt-5"> {/* Добавляем контейнер Bootstrap */}
            <div className="game-board">
                <div className="row">
                    <div className="col">
                        <Square value={squares[0]} onClick={() => handleSquareClick(0)}  />
                    </div>
                    <div className="col">
                        <Square value={squares[1]} onClick={() => handleSquareClick(1)}  />
                    </div>
                    <div className="col">
                        <Square value={squares[2]} onClick={() => handleSquareClick(2)}  />
                    </div>
                </div>
                <div className="row">
                    <div className="col">
                        <Square value={squares[3]} onClick={() => handleSquareClick(3)}  />
                    </div>
                    <div className="col">
                        <Square value={squares[4]} onClick={() => handleSquareClick(4)}  />
                    </div>
                    <div className="col">
                        <Square value={squares[5]} onClick={() => handleSquareClick(5)}  />
                    </div>
                </div>
                <div className="row">
                    <div className="col">
                        <Square value={squares[6]} onClick={() => handleSquareClick(6)}  />
                    </div>
                    <div className="col">
                        <Square value={squares[7]} onClick={() => handleSquareClick(7)}  />
                    </div>
                    <div className="col">
                        <Square value={squares[8]} onClick={() => handleSquareClick(8)}  />
                    </div>
                </div>
            </div>
            <div className="status">{status}</div>
            <button className="btn btn-primary restart-button" onClick={handleRestart}>
                New Game
            </button>
        </div>
    );
};

export default Board;
