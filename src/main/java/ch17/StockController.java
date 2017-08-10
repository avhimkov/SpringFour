package ch17;

import org.springframework.stereotype.Controller;

@Controller
public class StockController {
    private TaskScheduler taskScheduler;
    private SimpMessagingTemplate simpMessagingTemplate;
    private List<Stock> stocks = new ArrayList<Stock>(};
    private Random random = new Random(System.currentTimeMillis(}};
}
