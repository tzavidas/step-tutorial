class CommentFacade {
    constructor(commentFetcher, commentRenderer) {
        this.commentFetcher = commentFetcher;
        this.commentRenderer = commentRenderer;

        this.refreshComments();
    }


    /**
     * posts a comment
     * @async
     * @param name the name of the author of the comment
     * @param description the comment body
     */
    async postComment(name, description) {
        const isSuccessful = await this.commentFetcher.postComment(name, description);

        if(isSuccessful) {
            this.refreshComments();
        } else {
            alert('Your comment has not been posted! Please try again later!');
        }
    }

    /**
     * refreshes the comment section
     * @async
     */
    async refreshComments() {
        const comments = await this.commentFetcher.getAllComments();

        this.commentRenderer.render(comments);
    }
}
