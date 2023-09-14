const t = setInterval(move, 20);
let pos = 0;
const box = document.getElementById('box');
let flag = true;

function move() {
    if (pos === 150) {
        flag = false;
    }
    if (pos === 0) {
        flag = true;
    }

    if (flag) {
        pos++;
    } else {
        pos--;
    }

    box.style.top = pos + 'px';
    box.style.left = pos + 'px';
}
