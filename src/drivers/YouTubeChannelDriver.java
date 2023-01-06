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
        // YouTubeChannel channel = new YouTubeChannel(
        //         "Counting Numbers", 11000);

        System.out.println("Hello, welcome to the channel growth driver!\n");

        YouTubeChannel channel = getChannelInfo();
        displayChannelStatus(channel);

        menu();

        // timeToSubGoal(channel);

    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Please select an option: ");
        System.out.println("1: Growth rate needed to reach sub goal in x months.");
        System.out.println("2: Time it will take to reach sub goal with given growth rate.");

        choice = Integer.parseInt(scanner.nextLine());
        
        scanner.close();
    }

    private static YouTubeChannel getChannelInfo() {
        String name;
        int subCount;

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("What is your channel name? ");
        name = scanner.nextLine();
        System.out.print("What is your channel subscriber count? ");
        subCount = Integer.parseInt(scanner.nextLine());
        
        scanner.close();
        return new YouTubeChannel(name, subCount);
    }

    private static void timeToSubGoal() {
        double channelGrowthRate;
        int subCount;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your current subscriber count: ");
        subCount = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter a growth rate percentage: ");
        channelGrowthRate = Double.parseDouble(scanner.nextLine());
        // System.out.println("Channel growth rate is: " + channelGrowthRate);
        System.out.print("Enter your subscriber goal: ");
        int subGoal = Integer.parseInt(scanner.nextLine());
        System.out.println("Sub goal is: " + subGoal);
        System.out.println();

        int monthsPassed = 0;
        int newSubscriberCount = subCount;
        

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
        System.out.println("Subscriber count: " + channel.subscribers() + "\n");
    }
}
