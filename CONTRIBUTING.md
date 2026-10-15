# Contributing

## Working in a git worktree

Worktrees let you check out another branch into its own folder, with its
own working directory, while sharing the same `.git` history — useful for
running an agent on a branch without disturbing your main checkout.

### Create a new worktree

From the main checkout, create a worktree for a branch:

```
git worktree add <folder>/<path>/<branch-name>
```

This will create a new branch <branch-name> and checks out the branch at folder <branch-name>

If the branch doesn't exist yet, create it at the same time:

```
git worktree add -b <branch-name> <folder>/<path>/<branch-name>
```

List existing worktrees at any time with:

```
git worktree list
```

### Access the worktree

The worktree is just a normal folder — `cd` into it (or open it as the
project root in your editor/IDE) to work there:

```
cd <folder>/<path>/<branch-name>
```

### Set the worktree's git identity

First, enable worktree-specific configuration:

```
git config extensions.worktreeConfig true
```

Set the worktree's local git identity to the desired setting - this could be an AI Agent's name to distinguish it from
your own commits:

```
git config --worktree user.name "Your Name"
git config --worktree user.email "you@example.com"
```

This is a per-worktree, local-only config change (it does not touch global
git config) and ensures commits made from the worktree are attributed
correctly instead of falling back to whatever identity is configured
globally on the machine.

### Removing a worktree when done

```
git worktree remove <folder>/<path>/<branch-name>
```
