package drivers;

import entities.YouTubeChannel;

import java.util.Scanner;

/*
 * Goals:
 * Create channel
 * Display subscriber count
 * Given growth rate and subscriber goal, show how many months it will take to reach sub goal
 * Given subscriber goal and number of months, show growth rate needed to reach sub goal in that time (display subs gained per month)
 */

public class YouTubeChannelDriver {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel(
                "Counting Numbers", 11000);

        int subscribers;
        double channelGrowthRate;

        System.out.println("Hello, welcome to the channel growth driver!");

        displayChannelStatus(channel);

        timeToSubGoal(channel);

    }

    private static void timeToSubGoal(YouTubeChannel channel) {
        double channelGrowthRate;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a growth rate percentage: ");
        channelGrowthRate = Double.parseDouble(scanner.nextLine());
        // System.out.println("Channel growth rate is: " + channelGrowthRate);
        System.out.print("Enter your subscriber goal: ");
        int subGoal = Integer.parseInt(scanner.nextLine());
        System.out.println("Sub goal is: " + subGoal);
        System.out.println();

        int monthsPassed = 0;
        int newSubscriberCount = channel.subscribers();
        

        while (newSubscriberCount < subGoal) {
            newSubscriberCount *= channelGrowthRate;
            monthsPassed++;
            System.out.println("Month " + monthsPassed + ": "
                    + newSubscriberCount + " subscribers");
        }
        System.out.println();

        System.out.println("It would take roughly " + ((double) monthsPassed / 12) +
            monthsPassed % 12 + " years to reached this goal");

        scanner.close();
    }

    private static void displayChannelStatus(YouTubeChannel channel) {
        System.out.println("Channel name: " + channel.name());
        System.out.println("Subscriber count: " + channel.subscribers());
    }
}
