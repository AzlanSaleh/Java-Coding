package com;

import java.util.Scanner;



public class l10t1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the type of device (Light/Thermostat/Speaker): ");
        String deviceType = scanner.nextLine();

        SmartDevice device = null;

        switch (deviceType.toLowerCase()) {
            case "light":
                System.out.print("Enter device name: ");
                String lightName = scanner.nextLine();
                System.out.print("Enter light color: ");
                String color = scanner.nextLine();
                device = new SmartLight(lightName, color);
                break;

            case "thermostat":
                System.out.print("Enter device name: ");
                String thermostatName = scanner.nextLine();
                System.out.print("Enter temperature: ");
                double temperature = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                device = new SmartThermostat(thermostatName, temperature);
                break;

            case "speaker":
                System.out.print("Enter device name: ");
                String speakerName = scanner.nextLine();
                System.out.print("Enter volume: ");
                int volume = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                device = new SmartSpeaker(speakerName, volume);
                break;

            default:
                System.out.println("Invalid device type.");
                scanner.close();
                return;
        }

        // Interact with the device
        device.turnOn();
        System.out.println(device.getDeviceInfo());

        if (device instanceof Connectable) {
            System.out.print("Enter WiFi network name to connect: ");
            String networkName = scanner.nextLine();
            ((Connectable) device).connectToWiFi(networkName);

            System.out.println("Disconnecting from WiFi...");
            ((Connectable) device).disconnectFromWiFi();
        }

        device.turnOff();
        System.out.println(device.getDeviceInfo());

        scanner.close();
    }
}


