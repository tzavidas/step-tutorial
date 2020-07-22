class CommentFetcher {
    constructor(fetch = window.fetch) {
        this.fetch = fetch;
    }

    /**
     * fetches all comments
     * @async
     * @returns an array with comments
     */
    async getAllComments() {
        const url = '/comments';

        const res = await fetch(url);
        const comments = await res.json();

        return comments;
    }
}
