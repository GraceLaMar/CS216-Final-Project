# basketball_points_gui.py
# 04-25-25
# Grace La Mar
# this program reads the csv file and use the points scored to create a pie graph and give a summary

import tkinter as tk
from tkinter import Canvas
import csv

# Function to read CSV file, summarize data, draw graph, write summary to CSV
def process_data():
    # (1) Read text or CSV file and summarize data
    input_filename = "basketball_points.csv"
    output_filename = "basketball_summary.csv"
    
    players = []
    points = []
    
    with open(input_filename, "r") as file:
        csv_reader = csv.reader(file)
        next(csv_reader)  # Skip header
        for row in csv_reader:
            players.append(row[0])
            points.append(int(row[1]))
    
    # Print summary to console
    print("Player Points Summary:")
    for player, point in zip(players, points):
        print(f"{player}: {point}")
    print("\nDone reading file")
    
    # (2) Draw graph
    total_points = sum(points)
    start_angle = 270
    colors = ["red", "blue", "green", "yellow", "orange", "purple", "cyan", "magenta", "lime", "pink"]
    
    for i in range(len(points)):
        extent = points[i] / total_points * 360
        canvas.create_arc(50, 50, 250, 250, start=start_angle, extent=extent, fill=colors[i % len(colors)])
        start_angle += extent
    
    # (3) Write summary to a new CSV file
    with open(output_filename, "w", newline="") as file:
        csv_writer = csv.writer(file)
        csv_writer.writerow(["Player", "Points"])
        for player, point in zip(players, points):
            csv_writer.writerow([player, point])
    
    print("\nSummary written to:", output_filename)

# Function to clear graph - called by File, New
def clear_graph():
    canvas.delete("all")
      
# Function to exit program - called by File, Exit
def exit_program():
    main.destroy()

# Main window setup
main = tk.Tk()
main.geometry('400x350')
main.title('Basketball Stats Visualization')

# Create canvas
canvas = Canvas(main, width=300, height=300, bg='white')
canvas.pack()

# Create a menu bar
menu_bar = tk.Menu(main)

# Add "File" menu
file_menu = tk.Menu(menu_bar, tearoff=0)
file_menu.add_command(label="New", command=clear_graph)
file_menu.add_separator()
file_menu.add_command(label="Open", command=process_data)
file_menu.add_separator()
file_menu.add_command(label="Exit", command=exit_program)
menu_bar.add_cascade(label="File", menu=file_menu)

# Set the menu bar
main.config(menu=menu_bar)

# Wait for menu selections
main.mainloop()