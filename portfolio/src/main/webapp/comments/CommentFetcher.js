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

    async getBlobUploadUrl() {
        const url = '/blobstore';

        const res = await fetch(url);
        const blobstoreUploadUrl = await res.text();

        return blobstoreUploadUrl;
    }

    /**
     * function that makes a POST request add a comment
     * @async
     * @param name the name of the author of the comment
     * @param description the comment body
     * @param images array of the image files associated with the comment
     * @returns {boolean} wheter the action was successful
     */
    async postComment(name, description, images) {
        const url = await this.getBlobUploadUrl();

        const formData = new FormData();
        formData.append('name', name);
        formData.append('description', description);

        for(const image of images) {
            formData.append('images', image);
        }
        

        const res = await fetch(url, {
            method: 'POST',
            body: formData
        });

        const text = await res.text();

        return text === 'success';
    }
}

const convertJSONToQueryString = (obj) => {
    if(obj === {} || !obj) { //null or empty
        return '';
    }

    let queryString = '';

    for(const key in obj) {
        queryString += `${key}=${obj[key]}&`;
    }

    return queryString.slice(0, -1); //remove last character (the redundant &)
}
