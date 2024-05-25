package net.codejava.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository repo;
	
	@GetMapping("/categories")
	public String listCategories(Model model) {
		List<Category> listCategories=repo.findAll();
		model.addAttribute("listCategories",listCategories);
		return "categories";
	}
	
	@GetMapping("/categories/new")
	public String showCategoryNewform(Model model) {
		model.addAttribute("categroy", new Category());
		return"category_form";
		
	}
	
	@PostMapping("/categories/save")
	public String saveCategory(Category categroy) {
		repo.save(categroy);
		return "redirect:/categories";

	}
}
