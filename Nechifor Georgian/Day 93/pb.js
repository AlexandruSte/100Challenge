function matr() {
    let m = Math.floor(Math.random() * 20);
    let n = Math.floor(Math.random() * 10);
    let matrix = new Array(n);
    for(let i = 0; i < n; i++){
        matrix[i] = new Array(m);
        for(let j = 0; j < m; j++) {
            matrix[i][j] = Math.floor(Math.random() * 100);
        }
    }
    console.log(`%c Random matrix`, `color: red; font-size: 25px; font-weight: bold`);
    console.table(matrix);

    return matrix;
}

const m = matr();
