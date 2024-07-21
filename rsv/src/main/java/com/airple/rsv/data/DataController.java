package com.airple.rsv.data;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/data")
@RequiredArgsConstructor
@Controller
public class DataController {

    private final DataService dataService;


    @GetMapping("/list")
	public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "kw", defaultValue = "") String kw) {
		// List<Question> questionList = this.questionService.getList();
		// model.addAttribute("questionList", questionList);
		log.info("page:{}, kw:{}", page, kw);
		Page<Question> paging = this.dataService.getList(page, kw);
		model.addAttribute("paging", paging);
		model.addAttribute("kw", kw);
		return "question_list";
	}

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String createData(Model model, @PathVariable("id") Integer id) {
        return "데이터관리화면 리다이렉트";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String dataModify() {

        return "데이터관리화면 리다이렉트";
    }

    // @PreAuthorize("isAuthenticated()")
    // @PostMapping("/modify/{id}")
    // public String dataModify() {

    // return "";
    // }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String dataDelete() {
        return "";
    }
}
