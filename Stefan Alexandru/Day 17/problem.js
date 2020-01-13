// https://www.codewars.com/kata/build-a-pile-of-cubes/train/javascript
function findNb(m) {
    for (let n = 1; ; n++) {
        if (m > 0) {
            m = m - Math.pow(n, 3);
        } else if (m === 0) {
            return n;
        } else if (m < 0) {
            return -1;
        }
    }
}