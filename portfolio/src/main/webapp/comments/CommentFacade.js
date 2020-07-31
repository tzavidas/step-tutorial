class CommentFacade {
    constructor(commentFetcher, commentRenderer, commentFormRenderer) {
        this.commentFetcher = commentFetcher;
        this.commentRenderer = commentRenderer;
        this.commentFormRenderer = commentFormRenderer;

        this.state = {
            user: false,
            comments: []
        };

        this.refreshComments();
        this.userUpdate(this.state.user);
    }

    userUpdate(email) {
        const hasUser = (email !== ''); // boolean

        Object.assign(this.state, {
            user: hasUser
        });

        this.commentFormRenderer.render(this.state.user);
    }

    commentsUpdate(comments) {
        Object.assign(this.state, {
            comments
        });

        this.commentRenderer.render(this.state.comments);
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

        this.commentsUpdate(comments);
    }
}
