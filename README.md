
Main Scenarios for search endpoint:
----------------------------------
1. Search by Valid Brewery Name: API returns correct details.
2. Search by Valid Brewery City: API returns correct details.
3. Search by Valid Brewery Country: API returns correct details.
4. Search with No Results: Verify the API handles cases with no matching breweries.
5. Response Schema Validation: Ensure all required fields (id, name, brewery_type, etc.) are present in each response.

Additional Scenarios for search endpoint:
----------------------------------------
1. Search with Partial Matches: Confirm the API supports partial matches for brewery names.
2. Case-Insensitive Search: Ensure searches return consistent results regardless of case.
3. Search by Brewery Type: Validate filtering results by types like "micro," "regional," etc.
4. Search with Special Characters: Handle cases like apostrophes or other symbols.
5. Pagination Handling: Ensure the API paginates results correctly for large datasets.
6. Validation of Non-Required Fields: Check if optional fields like street, longitude, latitude, etc., are handled correctly.
7. Response Schema Validation: Ensure all required fields (id, name, brewery_type, etc.) are present in each response.
8. Performance Testing: Verify the API response time for typical and edge-case queries.

<hr/>

