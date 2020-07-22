class CommentFacade {
    constructor(commentFetcher, commentRenderer) {
        this.commentFetcher = commentFetcher;
        this.commentRenderer = commentRenderer;

        this.refresh();
    }

    /**
     * refreshes the comment section
     */
    async refresh() {
        const comments = await this.commentFetcher.fetchComments();

        this.commentRenderer.render(comments);
    }
}
