# Repository Security Hardening Guide

## devmirkoo/ExercicesJava-Unime — Configurazione manuale in GitHub Settings

Questo documento elenca **passo per passo** tutte le impostazioni di sicurezza da applicare manualmente nella UI di GitHub.  
Queste configurazioni **non possono essere applicate tramite Pull Request** e devono essere impostate da un repository admin.

---

## 1. Ruleset su `main` — Branch Protection

### Percorso
`Settings` → `Rules` → `Rulesets` → **New branch ruleset**

### Configurazione

| Impostazione | Valore consigliato |
|---|---|
| **Ruleset name** | `Protect main` |
| **Enforcement status** | `Active` |
| **Target branches** | `Include by pattern` → `main` |

### Bypass list

- **Lasciare la lista vuota** (consigliato per massima sicurezza).
- In alternativa, aggiungere **solo** `@devmirkoo` (tipo: `User`) — mai aggiungere "Admins" come ruolo generico, perché bypassa anche altri admin futuri.

### Regole da abilitare

#### ✅ Require a pull request before merging
- **Required approvals:** `1`
- **Require review from Code Owners:** `ON` ← fondamentale con il file CODEOWNERS presente
- **Dismiss stale approvals when new commits are pushed:** `ON`
- **Require approval of the most recent reviewable push:** `ON`

> ⚠️ Non abilitare "Require approval from someone other than the last person to push" se sei l'unico maintainer — bloccherebbe il tuo stesso merge.

#### ✅ Require status checks to pass before merging
- **Require branches to be up to date before merging:** `ON`
- **Status checks richiesti — aggiungi esattamente questi nomi:**

  | Nome check (esatto) | Workflow file | Job |
  |---|---|---|
  | `build` | `.github/workflows/ci.yml` | `build` |

  > Il nome del check corrisponde al campo `name:` del job nel workflow CI (`build`).  
  > Prima di aggiungere il check come "Required", assicurati che il workflow sia già stato eseguito almeno una volta su una PR, altrimenti GitHub non mostrerà il check nell'elenco.

#### ✅ Require signed commits
- Abilitare. Impedisce commit non firmati/alterati su `main`.

#### ✅ Require linear history
- Abilitare. Forza squash o rebase invece di merge commit, mantenendo la history pulita.

#### ✅ Restrict deletions
- Abilitare (di solito attivo di default). Impedisce la cancellazione del branch `main`.

#### ✅ Block force pushes
- Abilitare. Impedisce `git push --force` su `main`.

---

## 2. Secret Scanning e Push Protection

### Percorso
`Settings` → `Security` → `Code security and analysis`

### Configurazione

| Feature | Azione |
|---|---|
| **Secret scanning** | Clicca **Enable** |
| **Push protection** | Clicca **Enable** |

**Push protection** blocca automaticamente i push che contengono segreti riconosciuti (token GitHub, AWS keys, ecc.) prima che raggiungano il repository.

---

## 3. Dependabot (opzionale, per il futuro)

Se in futuro la repository introdurrà dipendenze (Maven/Gradle), abilitare:

### Percorso
`Settings` → `Security` → `Code security and analysis`

| Feature | Azione |
|---|---|
| **Dependency graph** | Enable |
| **Dependabot alerts** | Enable |
| **Dependabot security updates** | Enable |

In alternativa, aggiungere il file `.github/dependabot.yml`:

```yaml
version: 2
updates:
  - package-ecosystem: "maven"
    directory: "/"
    schedule:
      interval: "weekly"
```

---

## 4. Impostazioni generali del repository

### Percorso
`Settings` → `General`

| Impostazione | Valore consigliato |
|---|---|
| **Allow merge commits** | ❌ Disabilitare (per mantenere linear history) |
| **Allow squash merging** | ✅ Abilitare |
| **Allow rebase merging** | ✅ Abilitare |
| **Automatically delete head branches** | ✅ Abilitare (pulizia automatica dopo merge) |

---

## 5. Verifica finale — Checklist

Dopo aver applicato tutte le impostazioni, verifica che:

- [ ] La tab `Settings → Rules → Rulesets` mostra il ruleset `Protect main` in stato `Active`
- [ ] Aprendo una PR verso `main`, il check `build` appare come required
- [ ] Tentare un `git push` diretto su `main` viene respinto con errore
- [ ] Tentare un push con un segreto (es. un token falso) viene bloccato da Push Protection
- [ ] Il merge di una PR senza approvazione viene bloccato
- [ ] Il merge di una PR con check CI fallito viene bloccato

---

## 6. Riepilogo file aggiunti da questa PR

| File | Scopo |
|---|---|
| `.github/pull_request_template.md` | Template obbligatorio per ogni PR |
| `.github/CODEOWNERS` | Assegna @devmirkoo come owner richiesto per ogni file |
| `SECURITY.md` | Policy di sicurezza e linee guida |
| `.github/workflows/ci.yml` | CI GitHub Actions — job `build` che compila tutti i `.java` |
| `docs/repo-security-hardening.md` | Questo documento — guida alla configurazione manuale |

---

## Riferimenti

- [GitHub Rulesets — Available rules](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-rulesets/available-rules-for-rulesets)
- [About CODEOWNERS](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-code-owners)
- [Secret scanning — Push protection](https://docs.github.com/en/code-security/secret-scanning/push-protection-for-repositories-and-organizations)
- [Enabling push protection](https://docs.github.com/en/code-security/how-tos/secure-your-secrets/prevent-future-leaks/enabling-push-protection-for-your-repository)
- [Managing and standardizing pull requests](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/getting-started/managing-and-standardizing-pull-requests)
