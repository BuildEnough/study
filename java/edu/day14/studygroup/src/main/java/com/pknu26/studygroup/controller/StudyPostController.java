    package com.pknu26.studygroup.controller;

    import com.pknu26.studygroup.service.StudyApplicationService;
    import java.util.List;

    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.RequestMapping;

    import com.pknu26.studygroup.dto.LoginUser;
    import com.pknu26.studygroup.dto.PageRequest;
    import com.pknu26.studygroup.dto.StudyPost;
    import com.pknu26.studygroup.service.CategoryService;
    import com.pknu26.studygroup.service.CommentService;
    import com.pknu26.studygroup.service.StudyPostService;
    import com.pknu26.studygroup.validation.CommentForm;
    import com.pknu26.studygroup.validation.StudyApplicationForm;
    import com.pknu26.studygroup.validation.StudyPostForm;

    import jakarta.servlet.http.HttpSession;
    import jakarta.validation.Valid;
    import lombok.RequiredArgsConstructor;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;

    /**
     * 260420. 첫 작성
     */
    @Controller
    @RequestMapping("/studypost")
    @RequiredArgsConstructor
    public class StudyPostController {

        private final StudyApplicationService studyApplicationService;
        private final StudyPostService studyPostService;
        private final CategoryService categoryService;
        private final CommentService commentService;

        // 260422 페이징 추가
        @GetMapping("/list")  // http://localhost:8080/studypost/list
        public String list(@ModelAttribute PageRequest pageRequest, Model model, HttpSession session) {
            LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

            if (loginUser == null) {
                return "redirect:/user/login"; // 로그인한 사람은 게시판 글 못씀
            }

            // 단순리스트 조회 시 사용한 방법
            // List<StudyPost> postList = this.studyPostService.getPostList();
            // model.addAttribute("postList", postList);
            model.addAttribute("response", this.studyPostService.getPostList(pageRequest));
            return "/post/list";   // templates/post/list.html
        }

        @GetMapping("/create")
        public String createForm(Model model, HttpSession session) {
            LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

            if (loginUser == null) {
                return "redirect:/user/login";
            }

            StudyPostForm studyPostForm = new StudyPostForm();

            model.addAttribute("studyPostForm", studyPostForm);
            model.addAttribute("categoryList", this.categoryService.getCategoryList());

            return "/post/form";
        }

        @PostMapping("/create")
        public String create(@Valid StudyPostForm studyPostForm,
                            BindingResult bindingResult,
                            Model model,
                            HttpSession session) {
            LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

            if (loginUser == null) {
                return "redirect:/user/login";
            }

            if (bindingResult.hasErrors()) {
                model.addAttribute("categoryList", this.categoryService.getCategoryList());
                return "/post/form";
            }

            studyPostForm.setUserId(loginUser.getUserId());

            studyPostService.createPost(studyPostForm);
            return "redirect:/studypost/list";
        }

        // 스터디게시글 상세보기
        @GetMapping("/detail/{postId}")
        public String detail(@PathVariable("postId") Long postId,
                            Model model,
                            HttpSession session) {
            LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

            if (loginUser == null) {
                return "redirect:/user/login";
            }

            StudyPost post = this.studyPostService.getPostDetail(postId);
            if (post == null) {
                return "redirect:/studypost/list";
            }

            model.addAttribute("post", post);
            model.addAttribute("commentList", this.commentService.getCommentList(postId));

            CommentForm commentForm = new CommentForm();
            commentForm.setPostId(postId);
            model.addAttribute("commentForm", commentForm);

            model.addAttribute("applicationList", this.studyApplicationService.getApplicationListByPostId(postId));

            StudyApplicationForm form = new StudyApplicationForm();
            form.setPostId(postId);
            model.addAttribute("studyApplicationForm", form);

            return "/post/detail";
        }

        @PostMapping("/delete/{postId}")
        public String delete(@PathVariable("postId") Long postId,
                            HttpSession session) {
            LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

            if (loginUser == null) {
                return "redirect:/user/login";
            }

            StudyPost post = this.studyPostService.getPostDetail(postId);

            if (post == null) {
                return "redirect:/studypost/list";
            }

            if (!post.getUserId().equals(loginUser.getUserId())) {
                return "redirect:/studypost/detail/" + postId;
            }

            this.studyPostService.deletePost(postId);

            return "redirect:/studypost/list";
        }

        @GetMapping("/edit/{postId}")
        public String editForm(@PathVariable("postId") Long postId,
                            Model model,
                            HttpSession session) {
            LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

            if (loginUser == null) {
                return "redirect:/user/login";
            }

            StudyPost post = this.studyPostService.getPostDetail(postId);

            if (post == null) {
                return "redirect:/studypost/list";
            }

            if (!post.getUserId().equals(loginUser.getUserId())) {
                return "redirect:/studypost/detail/" + postId;
            }

            StudyPostForm studyPostForm = new StudyPostForm();
            studyPostForm.setPostId(post.getPostId());
            studyPostForm.setCategoryId(post.getCategoryId());
            studyPostForm.setTitle(post.getTitle());
            studyPostForm.setMaxMembers(post.getMaxMembers());
            studyPostForm.setContent(post.getContent());

            model.addAttribute("studyPostForm", studyPostForm);
            model.addAttribute("categoryList", this.categoryService.getCategoryList());

            return "/post/form";
        }

        @PostMapping("/edit/{postId}")
        public String edit(@PathVariable("postId") Long postId,
                        @Valid StudyPostForm studyPostForm,
                        BindingResult bindingResult,
                        Model model,
                        HttpSession session) {
            LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

            if (loginUser == null) {
                return "redirect:/user/login";
            }

            StudyPost post = this.studyPostService.getPostDetail(postId);

            if (post == null) {
                return "redirect:/studypost/list";
            }

            if (!post.getUserId().equals(loginUser.getUserId())) {
                return "redirect:/studypost/detail/" + postId;
            }

            if (bindingResult.hasErrors()) {
                model.addAttribute("categoryList", this.categoryService.getCategoryList());
                return "/post/form";
            }

            studyPostForm.setPostId(postId);
            studyPostForm.setUserId(loginUser.getUserId());

            this.studyPostService.updatePost(studyPostForm);

            return "redirect:/studypost/detail/" + postId;
        }
    }