data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val text: String,
    val date: Int,
    val copyRight: String,
    val postType: String,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val isFavorite: Boolean,
    val comments: Comments = Comments(),
)

object WallService {
    private var posts = emptyArray<Post>()
    private var idPost = 0

    fun clear() {
        posts = emptyArray()
        idPost = 0
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++idPost)
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy()
                return true
            }
        }
        return false
    }

}

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = false,
    val canOpen: Boolean = false,
)


fun main() {
    val post = Post(
        0, 11, 22, "text", 1699473307, "https://www.unixtimestamp.com/ru/", "post",
        true, true, true, true, true
    )
    println(WallService.add(post))
    println(WallService.update(post))
}


