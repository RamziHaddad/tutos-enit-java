--non_usa_customers.sql: Provide a query showing Customers (just their full names, customer ID and country) who are not in the US. 1. 
select c.firstname, c.lastname, c.customerID, c.Country 
from customer c 
where c.Country != "USA";

--brazil_customers.sql: Provide a query only showing the Customers from Brazil. 2. 
select c.firstname, c.lastname, c.customerID, c.Country 
from customer c 
where c.Country == "Brazil";

--brazil_customers_invoices.sql: Provide a query showing the Invoices of customers who are from Brazil. The resultant table should show the customer's full name, Invoice ID, Date of the invoice and billing country. 3. 
select c.firstname, c.lastname, i.InvoiceId, i.InvoiceDate, c.Country 
from Customer c 
left join Invoice i on c.CustomerId == i.CustomerId 
where c.Country == "Brazil";

--sales_agents.sql: Provide a query showing only the Employees who are Sales Agents. 4. 
select e.FirstName, e.LastName, e.employeeID 
from Employee e 
where e.Title == "Sales Support Agent";

--unique_invoice_countries.sql: Provide a query showing a unique/distinct list of billing countries from the Invoice table. 5. 
select distinct i.billingCountry 
from invoice i;

--sales_agent_invoices.sql: Provide a query that shows the invoices associated with each sales agent. The resultant table should include the Sales Agent's full name. 6. 
select i.invoiceID, i.Total, e.FirstName || " " || e.LastName 
as "Sales Agent Name" 
from Invoice i, Employee e, Customer c 
where i.CustomerId == c.CustomerId 
and c.SupportRepId == e.EmployeeId;

--invoice_totals.sql: Provide a query that shows the Invoice Total, Customer name, Country and Sale Agent name for all invoices and customers. 7. 
select i.Total, c.FirstName || " " || c.LastName 
as "Customer", c.Country, e.FirstName || " " || e.LastName as "Sales Agent Name" 
from Invoice i, Employee e, Customer c 
where i.CustomerId == c.SupportRepId 
and c.SupportRepId == e.EmployeeId;

--total_invoices_{year}.sql: How many Invoices were there in 2009 and 2011? 8. 
select SUBSTR(i.InvoiceDate, 0, 5) as "Year", Count(i.InvoiceId) as "# of Invoices" 
from Invoice i 
where i.InvoiceDate LIKE "2009%" OR i.InvoiceDate LIKE "2011%" 
GROUP BY SUBSTR(i.InvoiceDate, 0, 5);

--total_sales_{year}.sql: What are the respective total sales for each of those years? 9. 
select SUBSTR(i.InvoiceDate, 0, 5) as "Year", Sum(i.Total) as "Total Sales" 
from Invoice i 
where i.InvoiceDate LIKE "2009%" OR i.InvoiceDate LIKE "2011%" 
GROUP BY SUBSTR(i.InvoiceDate, 0, 5);

--invoice_37_line_item_count.sql: Looking at the InvoiceLine table, provide a query that COUNTs the number of line items for Invoice ID 37 10. 
select Count(il.InvoiceId) as "Number of Line Items of Invoice 37" 
from InvoiceLine il 
where il.InvoiceId == 37;

--line_items_per_invoice.sql: Looking at the InvoiceLine table, provide a query that COUNTs the number of line items for each Invoice. HINT: GROUP BY 11. 
select i.InvoiceID, Count(i.InvoiceId) 
from InvoiceLine i 
GROUP BY i.InvoiceID;

--line_item_track.sql: Provide a query that includes the purchased track name with each invoice line item. 12. 
SELECT i.InvoiceLineID, t.Name 
FROM InvoiceLine i 
LEFT JOIN Track t 
Where i.TrackId == t.TrackId 
ORDER BY i.InvoiceLineId ASC;

--line_item_track_artist.sql: Provide a query that includes the purchased track name AND artist name with each invoice line item. 13. 
SELECT i.InvoiceLineID, t.Name, ar.Name 
FROM InvoiceLine i, Track t, Album a, Artist ar 
Where i.TrackId == t.TrackId 
And t.AlbumId == a.AlbumId 
And a.ArtistId == ar.ArtistID 
ORDER BY i.InvoiceLineId ASC;

--country_invoices.sql: Provide a query that shows the # of invoices per country. HINT: GROUP BY 14. 
SELECT i.BillingCountry, COUNT(i.BillingCountry) as "Number of Invoices" 
FROM Invoice i GROUP BY i.BillingCountry;

--playlists_track_count.sql: Provide a query that shows the total number of tracks in each playlist. The Playlist name should be include on the resulant table. 15. 
SELECT p.Name as "Playlist Name", Count(pt.TrackId) as "Number of Tracks" 
FROM Playlist p, PlaylistTrack pt 
WHERE p.PlayListId == pt.PlayListId 
GROUP BY p.PLaylistId;

--tracks_no_id.sql: Provide a query that shows all the Tracks, but displays no IDs. The result should include the Album name, Media type and Genre. 16. 
SELECT t.Name, a.Title as "Album Title", mt.Name as "Media Type", g.Name as "Genre" 
FROM Track t, Album a, MediaType mt, Genre g 
Where t.AlbumId == a.AlbumId 
AND t.MediaTypeId == mt.MediaTypeId 
AND t.GenreId == g.GenreId;

--invoices_line_item_count.sql: Provide a query that shows all Invoices but includes the # of invoice line items. 17. 
SELECT i.InvoiceId, COUNT(il.InvoiceLineId) as "# of Invoice Line Items" 
FROM Invoice i 
LEFT JOIN InvoiceLine il 
Where i.InvoiceId == il.InvoiceId 
GROUP BY i.InvoiceId;

--sales_agent_total_sales.sql: Provide a query that shows total sales made by each sales agent. 18. 
SELECT e.FirstName || " " || e.LastName as "Sales Rep", SUM(i.Total) as "Total Sales" 
FROM Employee e, Customer c, Invoice i 
Where e.EmployeeId == c.SupportRepId 
AND c.CustomerId == i.CustomerId 
GROUP By e.FirstName;

--top_2009_agent.sql: Which sales agent made the most in sales in 2009? 19. 
SELECT e.FirstName || " " || e.LastName as "Sales Rep", SUM(i.Total) as "Total Sales" 
FROM Employee e, Customer c, Invoice i 
Where e.EmployeeId == c.SupportRepId 
AND c.CustomerId == i.CustomerId 
AND i.InvoiceDate LIKE "2009%" 
Group BY e.FirstName || " " || e.LastName 
ORDER BY SUM(i.Total) DESC 
LIMIT 1; 

SELECT MAX(Total.Sales) as "Sales", Total.LastName 
FROM( 
	SELECT e.FirstName, e.LastName, i.invoiceDate, SUM(i.Total) as "Sales" 
	FROM Invoice i, Employee e, Customer c 
	WHERE e.EmployeeId == c.SupportRepId 
	AND i.InvoiceDate LIKE "2009%" 
	AND c.CustomerId == i.CustomerId group by e.LastName) as Total;

--Hint: Use the MAX function on a subquery. top_agent.sql: Which sales agent made the most in sales over all? 20. 
SELECT e.FirstName || " " || e.LastName as "Sales Rep", SUM(i.Total) as "Total Sales" 
FROM Employee e, Customer c, Invoice i 
Where e.EmployeeId == c.SupportRepId 
AND c.CustomerId == i.CustomerId 
GROUP BY e.FirstName || " " || e.LastName 
ORDER BY SUM(i.Total) DESC 
LIMIT 1;

--sales_agent_customer_count.sql: Provide a query that shows the count of customers assigned to each sales agent. 21. 
SELECT e.FirstName || " " || e.LastName as "Sales Rep", COUNT(c.SupportRepId) as "Num of Customers" 
FROM Employee e, Customer c 
Where c.SupportRepId == e.EmployeeId 
GROUP BY e.FirstName || " " || e.LastName;

--sales_per_country.sql: Provide a query that shows the total sales per country. 22. 
SELECT distinct i.BillingCountry, COUNT(i.InvoiceID) as "Number of Sales" 
FROM Invoice i 
GROUP BY i.BillingCountry;

--top_country.sql: Which country's customers spent the most? 23. 
SELECT distinct i.BillingCountry, SUM(i.Total) as "Total Sales" 
FROM Invoice i 
GROUP BY i.BillingCountry 
ORDER BY SUM(i.Total) DESC 
LIMIT 1;

--top_2013_track.sql: Provide a query that shows the most purchased track of 2013. 24. 
SELECT t.Name, COUNT(il.InvoiceLineId) 
FROM Track t, InvoiceLine il, Invoice i 
WHERE t.TrackId == il.TrackId 
AND il.InvoiceId == i.InvoiceId 
AND i.InvoiceDate LIKE "2013%" 
GROUP BY t.Name 
ORDER BY COUNT(il.InvoiceLineId) 
DESC Limit 1;

--top_5_tracks.sql: Provide a query that shows the top 5 most purchased tracks over all. 25. 
SELECT t.Name, COUNT(il.InvoiceLineId) 
FROM Track t, InvoiceLine il 
WHERE t.TrackId == il.TrackId 
GROUP BY t.Name 
ORDER BY COUNT(il.InvoiceLineId) DESC 
Limit 5;

--top_3_artists.sql: Provide a query that shows the top 3 best selling artists. 26. 
SELECT ar.Name, COUNT(il.TrackId) 
FROM Artist ar, Album al, Track t, InvoiceLine il 
Where ar.ArtistId == al.ArtistId 
AND al.AlbumId == t.AlbumId 
AND t.TrackId == il.TrackId 
GROUP BY ar.Name 
ORDER BY COUNT(il.TrackId) DESC 
LIMIT 3;

--top_media_type.sql: Provide a query that shows the most purchased Media Type. 27. 
SELECT mt.Name, COUNT(il.TrackId) 
FROM MediaType mt, Track t, InvoiceLine il 
WHERE mt.MediaTypeId == t.MediaTypeId 
AND t.TrackId == il.TrackId 
GROUP BY mt.Name 
ORDER BY COUNT(il.TrackId) DESC 
LIMIT 1;