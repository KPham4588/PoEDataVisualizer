---
name: find-references
description: Use this skill BEFORE writing or adding any new code (functions, endpoints, DTOs, mappers) in this repo. Searches for existing similar implementations, naming conventions, and patterns to follow instead of inventing new ones. Trigger whenever asked to add/implement/write a new feature, method, or file.
---

Before writing new code:
1. Grep for similar method/class names already in the codebase.
2. Check the relevant layer's existing conventions (e.g. Controllers call DAOs directly, no service layer — see CLAUDE.md).
3. Match naming, package structure, and style of nearby files rather than introducing new patterns.
4. Only proceed to write code after identifying what to follow or explicitly confirming nothing similar exists.
