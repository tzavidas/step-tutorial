/**
 * @param {function} a mock fetch object for testing purposes
 */
const fetchMessage = (fetchObj = null) => {
    const url = "/data";

    if(!fetchObj) { //no mock obj is assigned
        fetchObj = fetch;
    }
    
    fetchObj(url)
    .then(res => res.text())
    .then(msg => {
        document.getElementById("message-text").innerText = msg;
    })
}