package com.manning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by juho0 on 2017-07-16.
 */
@Controller
@RequestMapping("/")
@ConfigurationProperties(prefix = "amazon")
public class ReadingListController {
    private static final String reader = "craig";
    private ReadingListRepository readingListRepository;
    private AmazonProperties amazonProperties;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, AmazonProperties amazonProperties) {
        this.readingListRepository=readingListRepository;
        this.amazonProperties=amazonProperties;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String readersBooks(Model model) {
        List<Book> readingList=readingListRepository.findByReader(reader);
        if(readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonId", amazonProperties.getAssociateId());
        }
        return "readingList";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addToReadingList(Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/";
    }
}
