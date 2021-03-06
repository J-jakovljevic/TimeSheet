# Delta internship - Timesheet - Requirements only starter

A web application used for time tracking for all employees.

## Requirements
- As an employee I am able to log in using my email or username and password
- As an employee I am able to log out
- As an employee I can click on a log to go to home page (calendar view)
- As an employee I can see footer with copyright information on every page
- As an employee I can change my password
- As an employee if I forget my password I can request a new one from login page
- As an admin I can assign weekly working hours by admin.
    - This setting takes effect from the moment of setting it
    - Changes of weekly working hours can be tracking in database
- As an employee I can see all my logged hours in a calendar view.
    - I can see total hours logged for given month
    - Calendar view always starts on a monday and ends on sunday. Days prior to first of the current month and after the last of the current month are not counted towards monthly total. They are colored differently than current months days.
    - I can move between months with a prev-next functionality
    - Within selected month I can see total logged hours for every day within month
    - For all days up to current day (as in the present) I can click on the day and open a daily view where I see more details for it.
    - Past, current and future days are visually distinct in calendar view.
    - Past working days that do not have total logged hours equal or exceeding weekly hours / 5 are colored red
    - Past working days that have total logged hours equal or exceeding weekly hours / 5 are colored green.
- As an employee I can see daily view of tracked time
    - I am able to see, edit and add new logs
    - When editing and adding new logs I select client that owns the project, the project I'm working on, a type/category of work I've done, a short description, amount of regular hours worked, and amount of overtime hours worked.
    - For log to be valid description does not have to be provided.
    - Only one of regular hours and overtime hours can be provided. When entering one, the other is must be empty.
    - There is no limit to how many logs I can add for a day
    - I can switch between different days while moving for 1 day using prev-next functionality
    - I can switch between different days while moving for 1 week using prev-next functionality
    - When viewing any day I can see links to all the other days within containing week. I also see information about number of week within year.
    - I can back to calendar view
- As an admin I can do everything that a regular employee can do
- As an admin I can manage Clients, Projects, Categories and Employees in a uniform way
    - I can view them all in a list
        - I can view list of all letters. Selecting a letter in this list will filter the entities to only those whose name starts with that letter
        - I can select multiple letters and result should be union of all selected letters
        - I can search for them using their names, this works in unison with first letter filter
        - All result views are paginated on server.
    - I can add new entitity
    - I can edit entities
    - I can delete entities
    - When deleting I get prompted to confirm deletion
- As an admin, I can edit Clients
    - Clients have name and address. Address has mutliple parts (Street, City, Postal Code, Country)
- As an admin, I can edit Projects
    - Projects have name, description, client and team lead. Team lead is an employee.
    - Projects have employees that are working on it. Employee can have start and/or end date specified for that project. If they have those dates specified they cannot add new logs for that project outside of that range.
- As an admin, I can edit Categories
    - Categories have a name
- As an admin, I can edit Employees
    - Employees have Name, email, weekly working hours and role (currently admin or employee)
    - When adding an employee an invititation email is sent which employees can use to set their password and login
    - When editing employee email they get sent email on previous email address informing them of the change.
- As an admin I can reset employee password
    - This invalidates the current employee password
    - The employee gets sent an email which they can use to set their new password and login
- As an admin I can generate reports for entered logs
    - Reports are not saved anywhere
    - Reports can be generated based on some or all of the following filters:
        - By employee
        - By client
        - By project
        - By category
        - By start date
        - By end date
    - Report contains detailed information about logs, as well as total logged hours for selected filters
    - Report can be printed
    - Report can be exported as PDF
    - Report can be exported as csv
