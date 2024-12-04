Cover "Search Breweries"
---------------------------
Cover "Search Breweries" method of https://www.openbrewerydb.org/documentation
with autotests using Java + REST Assured
(pick up to 5 scenarios covering main method features and implement corresponding
autotest in code, the rest scenarios you think should be included in complete test suite can
be listed in readme file).

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
4. Search with Special Characters: Handle cases like apostrophes or other symbols. (example - Świdnica)
5. Pagination Handling: Ensure the API paginates results correctly for large datasets.
6. Validation of Non-Required Fields: Check if optional fields like street, longitude, latitude, etc., are handled correctly.
7. Response Schema Validation: Ensure all required fields (id, name, brewery_type, etc.) are present in each response.
8. Performance Testing: Verify the API response time for typical and edge-case queries.
9. Search with null query param, return status code 200 and some brewery with null fields.

<hr/>
<hr/>

Examine "List Breweries"
-----------------------
Examine "List Breweries" method and share your thoughts (in readme file) on how you  would apply test automation to it 
(what approach, test design techniques you'd choose etc).

Test Automation Strategy
------------------------
1. REST API Test Framework:
Use a robust framework like RestAssured (Java), junit, for API testing. 
For parallel run test use mavem-sure-fire-plugin. For reporting add Allure or ReportPortal.
For compare object and softAssertion use assertJ. Implement reusable utilities for sending requests, 
validating responses, and managing configurations.

2. Data-Driven Testing:
Dynamically generate test cases for different filter values (e.g., cities, countries, brewery types) 
using external datasets (e.g., CSV or JSON) or some property files.
This approach ensures that the API behaves consistently for diverse input scenarios.

3. Combination Testing:
Combine multiple filters in a single request (e.g., filter by city and type) to verify the API's ability 
to handle multiple query parameters correctly.

4. Boundary Value Analysis:
For parameters like per_page or postal_code, test with boundary values (e.g., 0, 1, max values) 
to verify the API handles edge cases properly.

5. Negative Testing:
Validate the API's behavior with invalid or missing input (e.g., unsupported brewery type, 
invalid postal codes, or malformed IDs, null).

6. Performance Testing:
Measure response time for large datasets or complex filters (e.g., 200 results per page, multiple filters applied).

7. Contract Testing:
Ensure the response adheres to the specified schema using tools like JSON Schema Validation.

Some of these points were implemented for the search endpoint.

<hr>

Test Design Techniques
----------------------
1. Equivalence Partitioning
- Group inputs into equivalence classes to ensure representative test coverage.
- Example: For the by_type filter, test with valid values (micro, nano, regional) and invalid ones (unknown, empty string).

2. Pairwise Testing
- Use combinatorial techniques to minimize test cases for multiple filters.
- Example: Test combinations like:
  - by_city + by_country
  - by_type + by_name

3. Boundary Value Analysis
- Example scenarios:
  - Verify per_page works correctly with values 1, 50, 200 (max), and 201 (invalid).
  - Validate postal_code with basic (12345) and extended (12345-6789 or 12345_6789) formats.
  
4. State Transition Testing
- Example: When using page and per_page, ensure the correct breweries are returned as the 
  user navigates through pages.

<hr>
<hr>

Test Cases
----------
- We can divide our test cases for the next category:
  /tests
    /functional
      - funcTest
    /performance
      - perfomeTest
    /negative
      - negativeTest

Functional Test Cases
---------------------
1. Basic List Retrieval:
- Send a request without filters and verify that 50 breweries are returned (default per_page).

2. Filter Testing:
- by_city: Verify that results are filtered to the specified city (e.g., Boston).
- by_country: Verify breweries are restricted to the selected country (e.g., United States).
- by_postal: Validate behavior for 5-digit, 9-digit postal codes, and incorrect formats.
- by_type: Verify breweries of each type are correctly returned.

3. Pagination:
- page: Test navigating through pages with per_page set to 50 and 200.
- Verify results do not overlap between pages.

4. Sorting:
- Test sorting with ascending (asc) and descending (desc) orders on fields like name, city, and state.
- Verify the API rejects sorting with by_dist.

5. Combination of Filters:
- Verify correct results when combining filters (e.g., by_city=Boston&by_type=micro).

6. Negative Tests:
- Use invalid filter values or unsupported combinations (e.g., by_type=invalidType) and expect a proper error response.

Performance Test Cases
----------------------
1. Measure response time when:
- Fetching the default 50 breweries.
- Fetching the maximum 200 breweries.
- Using complex filters like by_city, by_country, and by_type combined.

2. Test API stability with multiple simultaneous requests.

Edge Case Test Cases
-------------------
1. Empty Filters:
- Test with no query parameters and expect default behavior.

2. Invalid Input:
- Verify error handling for malformed IDs, unsupported types, or incorrect formats for postal_code.

3. No Results:
- Send a request with a valid filter but no matching results (e.g., by_city=NonExistentCity).

4. Large Dataset:
- Test with high-volume data to ensure the API can handle large responses gracefully.
