package travelAgency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import travelAgency.entity.Review;
import travelAgency.service.ReviewServiceImpl;
import java.util.List;

@Controller
@RequestMapping(path = "review")
public class ReviewController {
    
    private ReviewServiceImpl reviewService;

    @Autowired
    public void setReviewService(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(path = "get/{id}")
    public @ResponseBody
    String getReviewById(@PathVariable long id) {
        return "Review: " + reviewService.getById(id);
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody
    List<Review> getAllReview() {
        return reviewService.getAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addReview(@RequestParam String description) {
        Review review = new Review();
        review.setDescription(description);
        reviewService.add(review);
        return "Review was added" ;
    }

    @PutMapping(path = "/update/{id}")
    public @ResponseBody String updateReview(@PathVariable long id, @RequestParam String name) {
        reviewService.update(id, name);
        return "Review " + reviewService.getById(id) + " was updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteReview(@PathVariable long id) {
        reviewService.delete(id);
        return "Review with Id = " + id + " was deleted";
    }
}
