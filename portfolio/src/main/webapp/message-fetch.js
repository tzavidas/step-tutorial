//placeholder mock fetch object until this branch has access to the server
const fetchMock = () => {
    return (url) => {
        return Promise.resolve({
            text: () => {
                return Promise.resolve("Greetings from Nick! :)");
            }
        });
    };
}

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