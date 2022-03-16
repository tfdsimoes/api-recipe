db.createUser(
        {
            user: "user",
            pwd: "user",
            roles: [
                {
                    role: "readWrite",
                    db: "recipe-db"
                }
            ]
        }
);

db.createCollection('recipe');

db.recipe.insertMany(
  [
    {
        "name": "Pasta",
        "description": "Pasta dish",
        "ingredients": [
            {
                "name": "water",
                "quantity": 1,
                "units": "liter"
            },
            {
                "name": "pasta",
                "quantity": 1,
                "units": "kg"
            }
        ],
        "steps": [
            {
                "order": 1,
                "instructions": "boil water"
            },
            {
                "order": 2,
                "instructions": "put pasta inside"
            }
        ],
        "tools": [
            "stove",
            "pot"
        ]
    },
    {
          "name": "Rice",
          "description": "Rice dish",
          "ingredients": [
              {
                  "name": "water",
                  "quantity": 1,
                  "units": "liter"
              },
              {
                  "name": "rice",
                  "quantity": 1,
                  "units": "kg"
              }
          ],
          "steps": [
              {
                  "order": 1,
                  "instructions": "boil water"
              },
              {
                  "order": 2,
                  "instructions": "put rice inside"
              }
          ],
          "tools": [
              "stove",
              "pan"
          ]
      },
      {
          "name": "Apple",
          "description": "Apple",
          "ingredients": [
              {
                  "name": "Apple",
                  "quantity": 1,
                  "units": "kg"
              }
          ],
          "steps": [
              {
                  "order": 1,
                  "instructions": "Cut Apple"
              }
          ],
          "tools": [
              "knife"
          ]
      }
  ]
)
