# tdddemo

# Health care tdd demo
## Problem definition
Design a healcare system for provider name H3HQ (Quickest Quality Health Service).
Q2HS doent have tie-ups with any insurance company.
They need a system to generate bills and receive money from patients.
The bill will include patients’s account numbers, procedure details, and charges.
The system should support all available payment options.

## Domain vocabulary
Procedure => services provided to a patient like physiotheraphy, injection, oxygen,... Each procedure has a unique code

Service catalogue => cost of procedure changes with time => service catalogue keep track of price for each procedure/service. System should allow users to update costs of services and allow configureing procedures.

MRN => Medical Record Number => unique identify patients => generator

Encounter => contract between a hospital and a patient => created when a patient checkin hospital (admitted); has start & discharge date time (thời gian bắt đầu và ra viện), guarantor information (thông tin bảo lãnh), insurance details (chi tiết bảo hiểm),...; Multiple visits to a hospital creates multiple encounters.

## Goal 1: create a test class to add a procedure to the catalogue