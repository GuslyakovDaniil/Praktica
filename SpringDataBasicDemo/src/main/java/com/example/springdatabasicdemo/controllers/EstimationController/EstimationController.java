    package com.example.springdatabasicdemo.controllers.EstimationController;

    import com.example.springdatabasicdemo.dtos.EstimationDto;
    import com.example.springdatabasicdemo.models.Book;
    import com.example.springdatabasicdemo.repositories.EstimationRepository;
    import com.example.springdatabasicdemo.services.EstimationService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/Estimation")
    public class EstimationController {

        @Autowired
        private EstimationService<Integer> estimationService;
        @Autowired
        private EstimationRepository estimationRepository;

        @GetMapping("/by-mark/{mark}")
        public List<Book> getBooksByMark(@PathVariable double mark) {
            return estimationRepository.findBooksByMark(mark);
        }

        @GetMapping("/estimations/{id}")
        public EstimationDto getEstimationById(@PathVariable Integer id) {
            return estimationService.findEstimation(id).orElse(null);
        }

        @PostMapping("/estimations")
        public EstimationDto createEstimation(@RequestBody EstimationDto estimationDto) {
            return estimationService.registerEstimation(estimationDto);
        }

        @DeleteMapping("/estimations/{id}")
        public void deleteEstimation(@PathVariable Integer id) {
            estimationService.expelEstimation(id);
        }

    }
