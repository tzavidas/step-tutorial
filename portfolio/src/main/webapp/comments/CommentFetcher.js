class CommentFetcher {
    constructor(fetch = window.fetch) {
        this.fetch = fetch;

        this.url = '/comments';
    }

    /**
     * fetches all comments
     * @async
     * @returns an array with comments
     */
    async getAllComments() {
        const url = this.url;

        const res = await fetch(url);
        const comments = await res.json();

        return comments;
    }

    /**
     * function that makes a POST request add a comment
     * @async
     * @param name the name of the author of the comment
     * @param description the comment body
     * @returns true if the action was successful, else false
     */
    async postComment(name, description) {
        const url = this.url;

        const res = await fetch(url, {
            method: 'POST',
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: convertJSONToQueryString({
                name,
                description
            })
        });

        const text = await res.text();

        if(text === "Success") {
            return true;
        }

        return false;
    }
}

const convertJSONToQueryString = (obj) => {
    if(obj === {} || !obj) { //null or empty
        return "";
    }


    let queryString = "";

    for(const key in obj) {
        queryString += `${key}=${obj[key]}&`;
    }

    return queryString.slice(0, -1); //remove last character (the redundand &)
}
